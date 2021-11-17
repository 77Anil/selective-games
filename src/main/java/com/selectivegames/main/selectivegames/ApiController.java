package com.selectivegames.main.selectivegames;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.selectivegames.main.selectivegames.common.CommonModel;
import com.selectivegames.main.selectivegames.model.Category;
import com.selectivegames.main.selectivegames.model.DLR;
import com.selectivegames.main.selectivegames.model.Subscription;
import com.selectivegames.main.selectivegames.service.GameService;

@RestController
@RequestMapping("")

public class ApiController {

	@Autowired
	private GameService gameService;

	@GetMapping("/category")
	public List<Category> getCategoryList() {
		return gameService.getCategoryList();
	}

	@GetMapping("/category/{id}/games")
	public Category getGamesByCategoryId(@PathVariable Long id) {
		return gameService.getCategoryDetails(id);
	}

	@GetMapping("/CallBack")
	public DLR callbackReciever(DLR dlr) {
		return gameService.addToDLR(dlr);
	}

	@PostMapping("/subscribe/")
	public Subscription checkSubscription(@RequestBody CommonModel model) {
		return gameService.callSubscritionCheck(model.getService(), model.getAni());
	}
}
