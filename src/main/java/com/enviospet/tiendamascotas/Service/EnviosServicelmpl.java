package com.enviospet.tiendamascotas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.enviospet.tiendamascotas.Repository.EnviosRepository;
import org.springframework.stereotype.Service;

import com.enviospet.tiendamascotas.Model.Envios;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EnviosServicelmpl implements EnviosService {

    private static final Logger logger = LoggerFactory.getLogger(EnviosServicelmpl.class);


    @Autowired
    private EnviosRepository enviosRepository;

    @Override
    public List<Envios> listarEnvios() {
        logger.info("Listando todos los envíos");
        return enviosRepository.findAll();
    }

    @Override
    public Optional<Envios> listarEnviosPorId(Long id) {
        logger.info("Listando envío con id: {}", id);
        return enviosRepository.findById(id);
    }

    @Override
    public Envios crearEnvio(Envios envio) {
        logger.info("Creando nuevo envío: {}", envio);
        return enviosRepository.save(envio);
    }

    @Override
    public Envios actualizarEnvio(Long id, Envios envio) {
        if(enviosRepository.existsById(id)) {
            logger.info("Actualizando envío con id: {}", id);
            envio.setId(id);
            return enviosRepository.save(envio);
        }else{
            logger.warn("No se encontró envío con id: {}", id);
            return null;
        }
    }

    @Override
    public void eliminarEnvio(Long id) {
        logger.info("Eliminando envío con id: {}", id);
        enviosRepository.deleteById(id);
    }



}
