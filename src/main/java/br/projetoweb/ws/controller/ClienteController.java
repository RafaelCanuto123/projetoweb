package br.projetoweb.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.projetoweb.model.Cliente;
import br.projetoweb.model.ENAlternativo;
import br.projetoweb.repository.ClienteRepository;
import br.projetoweb.repository.ENAlternativoRepository;
import net.bytebuddy.asm.Advice.Exit;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cli;
	
	@Autowired
	private ENAlternativoRepository en;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form()
	{
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente)
	{
		try {
			cli.save(cliente);
			return "redirect:/cadastrarCliente";
			
		} catch (Exception e) {
			
			return "cliente/cnpjDuplicado";
		}
	}

	
	@RequestMapping("/clientes")
	public ModelAndView listaCliente() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Cliente> clientes = cli.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesCliente(@PathVariable("codigo") long codigo){
		Cliente cliente = cli.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("cliente/detalhesCliente");
		mv.addObject("cliente", cliente);
		Iterable<ENAlternativo> enalternativos = en.findByCliente(cliente);
		mv.addObject("enalternativos", enalternativos);
		
		return mv;	
	}
	
	@RequestMapping("/deletarCliente")
	public String deletarCliente(long codigo){
		Cliente cliente = cli.findByCodigo(codigo);
		cli.delete(cliente);
		return "redirect:/clientes";
		
	}
	
	
	@RequestMapping("/deletarENalternativo")
	public String deletarENalternativo(long codigo){
		ENAlternativo enAlternativo = en.findByCodigo(codigo);
		en.delete(enAlternativo);
		return "cliente/detalhesCliente";
		
		
	}
	
	
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.POST)
	public String detalhesClientePost(@PathVariable("codigo") long codigo, ENAlternativo ENalternativo){
		Cliente cliente = cli.findByCodigo(codigo);
		ENalternativo.setCliente(cliente);
		en.save(ENalternativo);
		return "redirect:/{codigo}";	
	}
	
}
