package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAllTurma() {
		return turmaRepository.findAll().isEmpty() ? null : turmaRepository.findAll();
	}

	public Turma findTurmaById(Integer id) {
		return turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;
	}
	
	public TurmaDTO findTurmaDTOById(Integer id) {
		Turma turma = turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get()
				: null;
		TurmaDTO turmaDTO = new TurmaDTO();
		if (null != turma) {

			turmaDTO = convertendoEntidadeParaDTO(turma);
			return turmaDTO;
		}
		return null;
	}

	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public TurmaDTO saveTurmaDTO(TurmaDTO turmaDto) {
        Turma turma = new Turma();
		turma = convertendoDTOparaEntidade(turmaDto);
		Turma turmaNova = turmaRepository.save(turma);

		return convertendoEntidadeParaDTO(turmaNova);
	}

	public Turma updateTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public void deleteTurma(Integer id) {
		turmaRepository.deleteById(id);

	}
	
	
	private TurmaDTO convertendoEntidadeParaDTO(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setIdTurma(turma.getIdTurma());
		
			return turmaDTO;
	}
	
	private Turma convertendoDTOparaEntidade(TurmaDTO turmadto) {
		Turma turma = new Turma();
		turma.setDataFim(turmadto.getDataFim());
		turma.setDataInicio(turmadto.getDataInicio());
		turma.setDuracaoTurma(turmadto.getDuracaoTurma());
		turma.setHorarioTurma(turmadto.getHorarioTurma());
		turma.setIdTurma(turmadto.getIdTurma());
		turma.setInstrutor(turmadto.getInstrutor());
		turma.setAtividade(turmadto.getAtividade());
		return turma;
	}
	
	
	/*
	public Boolean deleteTurmaComVerificacao(Integer id) {
		if (turmaRepository.findById(id).isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}
	*/
}
