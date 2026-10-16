package pe.uni.sistemaacademico.strategy;

import pe.uni.sistemaacademico.domain.DetalleMatricula;

import java.util.List;

public interface EstrategiaPromedio {
    double calcular(List<DetalleMatricula> detalles);
}