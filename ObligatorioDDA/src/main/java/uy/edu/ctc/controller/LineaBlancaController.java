package uy.edu.ctc.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.entity.LineaBlanca;
import uy.edu.ctc.service.ElectrodomesticoService;
import uy.edu.ctc.service.LineaBlancaService;


@Controller
public class LineaBlancaController {
	
	@Autowired
	private LineaBlancaService LineaBlancaAll;
	
	@GetMapping({ "/", "index.html" })
	public String verPaginaDeInicio(Model modelo) {
		List<LineaBlanca> lineaBlanca = (List<LineaBlanca>) LineaBlancaAll.findAll();
		modelo.addAttribute("LineaBlanca", lineaBlanca);
		return "index";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarLineaBlanca(Model modelo) {
		modelo.addAttribute("LineaBlanca", new LineaBlanca());
		return "nuevo";
	}
	
	@PostMapping("/nuevo")
	public String guardarLineaBlanca(@Validated Electrodomestico lineaBlanca, BindingResult bindingResult,
			RedirectAttributes redirect, Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("LineaBlanca", lineaBlanca);
			return "redirect:/";
		}

		LineaBlancaAll.save(lineaBlanca);
		redirect.addFlashAttribute("msgExito", "El electrodoméstico de línea blanca ha sido agregado con exito");
		return "redirect:/";
	}
	
	@GetMapping("/{id}/editar")
	public String mostrarFormEditarContacto(@PathVariable Long id, Model modelo) {
	    Optional<Electrodomestico> LineaBlanca = LineaBlancaAll.findById(id);
	    modelo.addAttribute("LineaBlanca", LineaBlanca.orElse(new LineaBlanca())); 
	    return "nuevo";
	}
	
	@PostMapping("/{id}/editar")
    public String actualizarContacto(@PathVariable Long id, @Validated LineaBlanca LineaBlanca,
            BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        Optional<Electrodomestico> LineaBlancaDB = LineaBlancaAll.findById(id);
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("LineaBlanca", LineaBlanca);
            return "redirect:/";
        }

        LineaBlancaDB.ifPresent(c -> {
            c.setNombre(LineaBlanca.getNombre());
            c.setMarca(LineaBlanca.getMarca());
            c.setPrecio(LineaBlanca.getPrecio());
            c.setCapacidad(LineaBlanca.getCapacidad());

            LineaBlancaAll.save(c);
        });

        redirect.addFlashAttribute("msgExito", "El electrodoméstico de línea blanca ha sido actualizado correctamente");
        return "redirect:/";
    }
	
	@PostMapping("/{id}/eliminar")
    public String eliminarLineaBlanca(@PathVariable Long id, RedirectAttributes redirect) {
        LineaBlancaAll.deleteById(id);
        redirect.addFlashAttribute("msgExito", "El electrodoméstico de línea blanca ha sido eliminado correctamente");
        return "redirect:/";
    }

	
}
