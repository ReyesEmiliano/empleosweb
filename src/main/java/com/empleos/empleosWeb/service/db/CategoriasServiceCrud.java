package com.empleos.empleosWeb.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.model.Vacante;
import com.empleos.empleosWeb.repository.CategoriasRepository;
import com.empleos.empleosWeb.service.IntCategoriasService;

@Service
@Primary
public class CategoriasServiceCrud implements IntCategoriasService{
	
	@Autowired
	CategoriasRepository repoCategorias;

	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return (List<Categoria>) repoCategorias.findAll();
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		repoCategorias.deleteById(idCategoria);
		
	}

	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		repoCategorias.save(categoria);
		
	}

	@Override
	public Categoria buscarPorId(Integer idcategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = repoCategorias.findById(idcategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public Page<Categoria> buscarTodas(Pageable page) {
	return repoCategorias.findAll(page);
	}

}
