package com.enviospet.tiendamascotas.Service;

import java.util.List;
import java.util.Optional;

import com.enviospet.tiendamascotas.Model.Envios;

public interface EnviosService {

    List<Envios> listarEnvios();
    Optional<Envios> listarEnviosPorId(Long id);
    Envios crearEnvio(Envios envio);
    Envios actualizarEnvio(Long id, Envios envio);
    void eliminarEnvio(Long id);

    
} 
