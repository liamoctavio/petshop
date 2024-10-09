package com.enviospet.tiendamascotas.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.enviospet.tiendamascotas.Model.Envios;
import com.enviospet.tiendamascotas.Repository.EnviosRepository;

import com.enviospet.tiendamascotas.Service.*;
import com.enviospet.tiendamascotas.Model.Envios;
import com.enviospet.tiendamascotas.Model.Envios;
import com.enviospet.tiendamascotas.Repository.EnviosRepository;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;






public class EnviosServiceTest {

    @Mock
    private EnviosRepository enviosRepository;

    @InjectMocks
    private EnviosServicelmpl enviosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarEnvio() {
        Envios envio = new Envios();
        envio.setDestinatario("John Doe");

        when(enviosRepository.save(any(Envios.class))).thenReturn(envio);

        Envios savedEnvio = enviosService.crearEnvio(envio);

        assertThat(savedEnvio).isNotNull();
        assertThat(savedEnvio.getDestinatario()).isEqualTo("John Doe");

        verify(enviosRepository, times(1)).save(envio);
    }

    @Test
    public void testBuscarEnvioPorId() {
        Envios envio = new Envios();
        envio.setDestinatario("Jane Doe");

        when(enviosRepository.findById(any(Long.class))).thenReturn(Optional.of(envio));

        Optional<Envios> foundEnvio = enviosService.listarEnviosPorId(1L);

        assertThat(foundEnvio).isPresent();
        assertThat(foundEnvio.get().getDestinatario()).isEqualTo("Jane Doe");

        verify(enviosRepository, times(1)).findById(1L);
    }

    @Test
    public void testEliminarEnvio() {
        doNothing().when(enviosRepository).deleteById(any(Long.class));

        enviosService.eliminarEnvio(1L);

        verify(enviosRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testListarTodosLosEnvios() {
        Envios envio1 = new Envios();
        envio1.setDestinatario("John Doe");

        Envios envio2 = new Envios();
        envio2.setDestinatario("Jane Doe");

        when(enviosRepository.findAll()).thenReturn(Arrays.asList(envio1, envio2));

        List<Envios> envios = enviosService.listarEnvios();

        assertThat(envios).hasSize(2);
        assertThat(envios).extracting(Envios::getDestinatario).containsExactlyInAnyOrder("John Doe", "Jane Doe");

        verify(enviosRepository, times(1)).findAll();
    }

}
