package pe.uni.sistemaacademico.strategy;

import pe.uni.sistemaacademico.domain.DetalleMatricula;

import java.util.List;

public class PromedioSimple implements EstrategiaPromedio {
    @Override
    public double calcular(List<DetalleMatricula> detalles) {
        List<DetalleMatricula> calificadas = detalles.stream()
                .filter(detalle -> detalle.getNota() != null)
                .toList();
        if (calificadas.isEmpty()) {
            throw new IllegalStateException("La matrícula todavía no tiene notas registradas.");
        }
        return calificadas.stream().mapToDouble(detalle -> detalle.getNota()).average().orElseThrow();
    }
}