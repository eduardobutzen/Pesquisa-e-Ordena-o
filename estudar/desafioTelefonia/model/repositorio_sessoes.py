from model.sessao import Sessao


# Guarda as sessoes em um HashMap (dict), usando o celular como chave.
class RepositorioSessoes:

    def __init__(self):
        self.sessoes = {}

    # Le o arquivo, cria um objeto Sessao por linha e faz o 'put' no dict.
    def carregar_arquivo(self, caminho):
        with open(caminho, encoding="utf-8") as arquivo:
            for linha in arquivo:
                if linha.strip():
                    sessao = Sessao.from_linha(linha)
                    self.sessoes[sessao.celular] = sessao  # put
        return len(self.sessoes)

    # Busca O(1) em media: retorna a Sessao ou None se nao existir.
    def buscar(self, celular):
        return self.sessoes.get(celular)

    def total(self):
        return len(self.sessoes)
