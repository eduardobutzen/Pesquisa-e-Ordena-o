import threading
import time


class SessaoController:
    """Liga a View (tela) com o Model (dados): recebe a opcao e decide o que fazer."""

    def __init__(self, repositorio, view):
        self.repositorio = repositorio
        self.view = view

    def iniciar(self, caminho_arquivo):
        total = self.repositorio.carregar_arquivo(caminho_arquivo)
        self.view.mostrar_mensagem(f"{total} sessoes carregadas no HashMap.")

        while True:
            opcao = self.view.mostrar_menu()
            if opcao == "1":
                self.buscar_um()
            elif opcao == "2":
                self.buscar_varios()
            elif opcao == "3":
                self.view.mostrar_mensagem(f"Total: {self.repositorio.total()} sessoes")
            elif opcao == "0":
                self.view.mostrar_mensagem("Saindo...")
                break
            else:
                self.view.mostrar_mensagem("Opcao invalida.")

    def buscar_um(self):
        celular = self.view.pedir_celular()
        sessao = self.repositorio.buscar(celular)
        if sessao:
            self.view.mostrar_sessao(sessao)
        else:
            self.view.mostrar_nao_encontrado(celular)

    def _buscar_em_thread(self, celular, resultados, posicao):
        """Executada por cada thread: faz a busca e guarda o resultado na sua posicao."""
        sessao = self.repositorio.buscar(celular)
        resultados[posicao] = (celular, sessao, threading.current_thread().name)

    def buscar_varios(self):
        """Desafio PLUS: cria uma thread para cada celular e busca todos ao mesmo tempo."""
        celulares = self.view.pedir_varios_celulares()
        if not celulares:
            self.view.mostrar_mensagem("Nenhum celular informado.")
            return

        resultados = [None] * len(celulares)
        threads = []

        inicio = time.perf_counter()
        for i, celular in enumerate(celulares):
            thread = threading.Thread(
                target=self._buscar_em_thread,
                args=(celular, resultados, i),
                name=f"Thread-{i + 1}",
            )
            threads.append(thread)
            thread.start()  # comeca a busca

        for thread in threads:
            thread.join()  # espera todas as threads terminarem
        fim = time.perf_counter()

        for celular, sessao, nome_thread in resultados:
            self.view.mostrar_resultado_thread(celular, sessao, nome_thread)
        self.view.mostrar_tempo(len(celulares), fim - inicio)
