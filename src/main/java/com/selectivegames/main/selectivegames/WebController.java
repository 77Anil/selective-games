package com.selectivegames.main.selectivegames;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.selectivegames.main.selectivegames.common.RedirectDataModel;
import com.selectivegames.main.selectivegames.common.ServiceStatus;
import com.selectivegames.main.selectivegames.service.GameService;

@Controller
@RequestMapping("/")
public class WebController {
	private static Logger logger = LoggerFactory.getLogger(WebController.class);
	@Autowired
	private GameService gameService;

	@Value("${external.url}")
	private String sdplUrl;

	@GetMapping("")
	public String home(ModelMap model) {

		model.addAttribute("cats", gameService.getCategoryList());
		return "online";
	}

	@GetMapping("login/{id}")
	public String login(@PathVariable Long id, ModelMap model, HttpSession session) {
		logger.info("User ID {}", id);
		model.addAttribute("cats", gameService.getCategoryList());
		session.setAttribute("user", id);
		// model.addAttribute("user", id);
		return "online";
	}

	@GetMapping("landing")
	public ModelAndView method(HttpServletResponse httpServletResponse) {
		return new ModelAndView("redirect:" + sdplUrl);
	}

	@GetMapping("cat/{id}")
	public String home(ModelMap model, @PathVariable long id) {

		model.addAttribute("cats", gameService.getCategoryList());

		model.addAttribute("games", gameService.getCategoryDetails(id));
		return "showAll";
	}

	@GetMapping("play/{id}")
	public String redirectToPlay(ModelMap model, @PathVariable Long id) {
		model.addAttribute("game", gameService.getGameDetails(id));
		return "play";
	}

	@GetMapping("redirect")
	public String subRedirect(RedirectDataModel model, ModelMap modelMap) {
		logger.info("{}", model.getRc());
		model = gameService.updateDate(model);
		gameService.addRedirectLogging(model);
		if (model.getRc().equalsIgnoreCase(ServiceStatus.CONFIRMED.toString())) {
			modelMap.addAttribute("scope", 1);
			modelMap.addAttribute("message", gameService.getMessage(1));
		} else if (model.getRc().equalsIgnoreCase(ServiceStatus.DECLINED.toString())) {
			modelMap.addAttribute("scope", 2);
			modelMap.addAttribute("message", gameService.getMessage(2));
		} else if (model.getRc().equalsIgnoreCase(ServiceStatus.ERROR.toString())) {
			modelMap.addAttribute("scope", 3);
			modelMap.addAttribute("message", gameService.getMessage(3));
		} else {
			modelMap.addAttribute("scope", 4);
			modelMap.addAttribute("message", gameService.getMessage(4));
		}

		modelMap.addAttribute("ani", model.getTn());
		modelMap.addAttribute("service", gameService.getServiceName(model.getCl()));
		return "process";
	}

}
