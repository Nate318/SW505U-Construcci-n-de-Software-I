import sqlite3


class RepositorioPedidos:
    def __init__(self, db_path=":memory:"):
        self.db_path = db_path
        # Una BD ":memory:" desaparece al cerrar su conexión; se reutiliza una sola
        self._conn_memoria = sqlite3.connect(":memory:") if db_path == ":memory:" else None
        self._crear_tabla()

    def _conexion(self):
        if self._conn_memoria is not None:
            return self._conn_memoria
        return sqlite3.connect(self.db_path)

    def _crear_tabla(self):
        with self._conexion() as conn:
            conn.execute("""
                CREATE TABLE IF NOT EXISTS pedidos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    cliente TEXT NOT NULL,
                    total REAL NOT NULL,
                    estado TEXT DEFAULT 'pendiente'
                )
            """)

    def guardar(self, cliente, total):
        with self._conexion() as conn:
            cursor = conn.execute(
                "INSERT INTO pedidos (cliente, total) VALUES (?, ?)",
                (cliente, total)
            )
            return cursor.lastrowid

    def obtener(self, pedido_id):
        with self._conexion() as conn:
            row = conn.execute(
                "SELECT id, cliente, total, estado FROM pedidos WHERE id = ?",
                (pedido_id,)
            ).fetchone()
            return row
