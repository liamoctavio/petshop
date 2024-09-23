package com.enviospet.tiendamascotas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.enviospet.tiendamascotas.Model.Envios;
import com.enviospet.tiendamascotas.Service.EnviosService;
import org.springframework.web.bind.annotation.PutMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/envios")
public class EnviosController {

    private static final Logger logger = LoggerFactory.getLogger(EnviosController.class);


    @Autowired
    private EnviosService enviosService;

    @GetMapping
    public List<Envios> listarEnvios() {
        logger.info("Listando todos los envíos");
        return enviosService.listarEnvios();
    }

    @GetMapping("/{id}")
    public Optional<Envios> listarEnviosPorId(@PathVariable Long id) {
        logger.info("Listando envío con id: {}", id);
        return enviosService.listarEnviosPorId(id);
    }

    @PostMapping
    public Envios crearEnvio(@RequestBody Envios envio) {
        logger.info("Creando nuevo envío: {}", envio);
        return enviosService.crearEnvio(envio);
    }

    @PutMapping("/{id}")
    public Envios actualizarEnvio(@PathVariable Long id, @RequestBody Envios envio) {
        logger.info("Actualizando envío con id: {}", id);
        return enviosService.actualizarEnvio(id, envio);
    }

    @DeleteMapping("/{id}")
    public void eliminarEnvio(@PathVariable Long id) {
        logger.info("Eliminando envío con id: {}", id);
        enviosService.eliminarEnvio(id);
    }

}
