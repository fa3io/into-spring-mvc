package br.com.devmedia.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.GenericDAO;
import br.com.devmedia.curso.domain.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private GenericDAO<Usuario> usuarioDao;
	
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		System.out.println("Controller Usuario");
		model.addAttribute("usuarios", usuarioDao.getTodos());
		return new ModelAndView("/user/list", model);
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap model){
		return "/user/add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr){
		usuarioDao.salvar(usuario);
		attr.addFlashAttribute("message","Usuario salvo com sucesso!");
		return "redirect:/usuario/todos";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){
		Usuario usuario = usuarioDao.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/add", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr){
		usuarioDao.editar(usuario);
		attr.addFlashAttribute("message","Usuario alterado com sucesso!");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	
	
	
	
	
	
}
