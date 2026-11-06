import os
import sys

import pytest

# Permite importar calculadora.py desde la carpeta raíz
sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))

from calculadora import sumar, dividir, es_mayor_de_edad


# CP-001 - Camino Normal
def test_sumar_positivos():
    assert sumar(2, 3) == 5


# CP-002 - Valor Límite
def test_mayor_edad_limite_inferior():
    assert es_mayor_de_edad(18) is True


def test_menor_edad_limite_superior():
    assert es_mayor_de_edad(17) is False


# CP-003 - Excepción
def test_dividir_por_cero():
    with pytest.raises(ValueError, match="No se puede dividir por cero"):
        dividir(10, 0)


# CP-004 - Entrada Inválida
def test_edad_negativa():
    with pytest.raises(ValueError, match="La edad no puede ser negativa"):
        es_mayor_de_edad(-5)


# CP-005 - Parametrizada
@pytest.mark.parametrize("a, b, esperado", [
    (1, 1, 2),
    (-1, 1, 0),
    (0, 0, 0),
    (100, 200, 300),
])
def test_sumar_parametrizado(a, b, esperado):
    assert sumar(a, b) == esperado
