from pathlib import Path

from controller.sessao_controller import SessaoController
from model.repositorio_sessoes import RepositorioSessoes
from view.terminal_view import TerminalView

ARQUIVO = Path(__file__).parent / "telephony_sessions.txt"


def main():
    repositorio = RepositorioSessoes()  # Model
    view = TerminalView()               # View
    controller = SessaoController(repositorio, view)  # Controller
    controller.iniciar(ARQUIVO)


if __name__ == "__main__":
    main()
