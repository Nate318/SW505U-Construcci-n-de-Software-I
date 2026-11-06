# Cómo generar los reportes (desde la carpeta lab_pytest)

    pip install pytest pytest-html pytest-cov
    pytest tests/ --html=reporte_completo.html --self-contained-html --cov=calculadora --cov-report=html --cov-report=term-missing

Genera `reporte_completo.html` y `htmlcov/index.html`. Súbelos a GitHub junto con el código.
