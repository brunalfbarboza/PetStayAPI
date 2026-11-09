package com.petstay.hotelcanino.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final PetService petService;

    private final UsuarioService usuarioService;


}
