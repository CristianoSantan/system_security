package mvc_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import mvc_security.dto.UserDto;
import mvc_security.entity.User;
import mvc_security.service.impl.UserService;

@Controller
public class AuthController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "home/home.html";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register/index.html";
	}

	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
		User existingUser = userService.findUserByEmail(userDto.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "Já existe uma conta cadastrada com o mesmo email");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", userDto);
			return "register";
		}

		userService.saveUser(userDto);
		return "login";
	}
}
