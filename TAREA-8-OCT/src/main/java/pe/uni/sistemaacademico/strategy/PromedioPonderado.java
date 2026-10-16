package pe.uni.sistemaacademico.strategy;

import pe.uni.sistemaacademico.domain.DetalleMatricula;

import java.util.List;

public class PromedioPonderado implements EstrategiaPromedio {
    @Override
    public double calcular(List<DetalleMatricula> detalles) {
        List<DetalleMatricula> calificadas = detalles.stream()
                .filter(detalle -> detalle.getNota() != null)
                .toList();
        if (calificadas.isEmpty()) {
            throw new IllegalStateException("La matrícula todavía no tiene notas registradas.");
        }
        int totalCreditos = calificadas.stream()
                .mapToInt(detalle -> detalle.getCurso().getCreditos())
                .sum();
        double sumaPonderada = calificadas.stream()
                .mapToDouble(detalle -> detalle.getNota() * detalle.getCurso().getCreditos())
                .sum();
        return sumaPonderada / totalCreditos;
    }
}