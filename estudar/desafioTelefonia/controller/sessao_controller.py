# Liga a View (tela) com o Model (dados): recebe a opcao e decide o que fazer.
class SessaoController:

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
