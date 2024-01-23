package mvc_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc_security.dto.UserDto;
import mvc_security.service.impl.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView usuario() {
		ModelAndView modelAndView = new ModelAndView("usuarios/index.html");
		List<UserDto> users = userService.findAllUsers();
		modelAndView.addObject("users", users);
		modelAndView.addObject("user", new UserDto());

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}
	
	@PostMapping()
	public String atuallizar(UserDto userDto) {
		userService.saveUser(userDto);
		return "redirect:/users";
	}

}
