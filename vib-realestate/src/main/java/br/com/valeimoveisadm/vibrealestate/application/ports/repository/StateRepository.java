package br.com.valeimoveisadm.vibrealestate.application.ports.repository;

import br.com.valeimoveisadm.vibrealestate.application.core.domain.State;

import java.util.List;

public interface StateRepository {
    State findById(Integer id);
    List<State> findAll();
}
