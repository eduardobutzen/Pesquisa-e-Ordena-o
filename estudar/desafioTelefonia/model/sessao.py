import json
from dataclasses import dataclass


# Representa uma sessao de telefonia (uma linha do arquivo).
@dataclass
class Sessao:

    celular: str
    session_id: str
    imsi: str
    imei: str
    mcc: str
    mnc: str
    cell_id: int
    lac: int
    bearer: str
    start_time: str
    end_time: str
    duration_s: int
    ip_addr: str
    sip_call_id: str
    codec: str
    bytes_up: int
    bytes_down: int
    lat: float
    lon: float
    encryption: str

    # Cria uma Sessao a partir de uma linha no formato 'celular;{json}'.
    @staticmethod
    def from_linha(linha):
        celular, dados_json = linha.strip().split(";", 1)
        dados = json.loads(dados_json)
        return Sessao(celular=celular, **dados)
