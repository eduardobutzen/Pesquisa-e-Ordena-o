class TerminalView:
    """Tudo que aparece na tela ou e lido do teclado fica aqui."""

    def mostrar_menu(self):
        print("\n===== SESSOES DE TELEFONIA =====")
        print("1 - Buscar um celular")
        print("2 - Mostrar total de sessoes")
        print("0 - Sair")
        return input("Opcao: ").strip()

    def pedir_celular(self):
        return input("Digite o celular: ").strip()

    def mostrar_sessao(self, sessao):
        print(f"\n--- Celular {sessao.celular} ---")
        print(f"Sessao:      {sessao.session_id}")
        print(f"IMSI / IMEI: {sessao.imsi} / {sessao.imei}")
        print(f"Rede:        {sessao.bearer} (MCC {sessao.mcc}, MNC {sessao.mnc})")
        print(f"Celula:      {sessao.cell_id} (LAC {sessao.lac})")
        print(f"Inicio:      {sessao.start_time}")
        print(f"Fim:         {sessao.end_time} ({sessao.duration_s} s)")
        print(f"IP:          {sessao.ip_addr}")
        print(f"Codec:       {sessao.codec} | Criptografia: {sessao.encryption}")
        print(f"Dados:       {sessao.bytes_up} bytes up / {sessao.bytes_down} bytes down")
        print(f"Local:       {sessao.lat}, {sessao.lon}")

    def mostrar_nao_encontrado(self, celular):
        print(f"\nCelular {celular} nao encontrado.")

    def mostrar_mensagem(self, mensagem):
        print(mensagem)
