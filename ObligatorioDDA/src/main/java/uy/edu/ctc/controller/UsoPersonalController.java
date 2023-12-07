package uy.edu.ctc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uy.edu.ctc.entity.Electrodomestico;
import uy.edu.ctc.entity.UsoPersonal;
import uy.edu.ctc.repository.ElectrodomesticoRepository;
import uy.edu.ctc.repository.UsoPersonalRepository;
import uy.edu.ctc.service.UsoPersonalService;

public class UsoPersonalController {
	
	@Autowired
	private ElectrodomesticoRepository UsoPersonalAll;

	@GetMapping({ "/", "index.html" })
	public String verPaginaDeInicio(Model modelo) {
		List<Electrodomestico> UsoPersonal = (List<Electrodomestico>) UsoPersonalAll.findAll();
		modelo.addAttribute("UsoPersonal", UsoPersonal);
		return "index";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioDeRegistrarUsoPersonal(Model modelo) {
		modelo.addAttribute("UsoPersonal", new UsoPersonal());
		return "nuevo";
	}
	
	@PostMapping("/nuevo")
	public String guardarLineaBlanca(@Validated Electrodomestico UsoPersonal, BindingResult bindingResult,
			RedirectAttributes redirect, Model modelo) {
		if (bindingResult.hasErrors()) {
			modelo.addAttribute("UsoPersonal", UsoPersonal);
			return "redirect:/";
		}

		UsoPersonalAll.save(UsoPersonal);
		redirect.addFlashAttribute("msgExito", "El electrodoméstico de uso personal ha sido agregado con exito");
		return "redirect:/";
	}
	
	@GetMapping("/{id}/editar")
	public String mostrarFormEditarContacto(@PathVariable Long id, Model modelo) {
	    Optional<Electrodomestico> UsoPersonal = UsoPersonalAll.findById(id);
	    modelo.addAttribute("UsoPersonal", UsoPersonal.orElse(new UsoPersonal())); 
	    return "nuevo";
	}
	
	@PostMapping("/{id}/editar")
    public String actualizarContacto(@PathVariable Long id, @Validated UsoPersonal UsoPersonal,
            BindingResult bindingResult, RedirectAttributes redirect, Model modelo) {
        Optional<Electrodomestico> UsoPersonalDB = UsoPersonalAll.findById(id);
        if (bindingResult.hasErrors()) {
            modelo.addAttribute("UsoPersonal", UsoPersonal);
            return "redirect:/";
        }

        UsoPersonalDB.ifPresent(c -> {
            c.setNombre(UsoPersonal.getNombre());
            c.setMarca(UsoPersonal.getMarca());
            c.setPrecio(UsoPersonal.getPrecio());
            c.setPotencia(UsoPersonal.getPotencia());

            UsoPersonalAll.save(c);
        });

        redirect.addFlashAttribute("msgExito", "El electrodoméstico de uso personal ha sido actualizado correctamente");
        return "redirect:/";
    }
	
	@PostMapping("/{id}/eliminar")
    public String eliminarLineaBlanca(@PathVariable Long id, RedirectAttributes redirect) {
        UsoPersonalAll.deleteById(id);
        redirect.addFlashAttribute("msgExito", "El electrodoméstico de uso personal ha sido eliminado correctamente");
        return "redirect:/";
    }
}
