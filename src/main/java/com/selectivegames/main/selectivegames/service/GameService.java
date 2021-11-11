package com.selectivegames.main.selectivegames.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.selectivegames.main.selectivegames.common.LogType;
import com.selectivegames.main.selectivegames.common.RedirectDataModel;
import com.selectivegames.main.selectivegames.model.Category;
import com.selectivegames.main.selectivegames.model.DLR;
import com.selectivegames.main.selectivegames.model.Game;
import com.selectivegames.main.selectivegames.model.Logging;
import com.selectivegames.main.selectivegames.model.Subscription;
import com.selectivegames.main.selectivegames.repository.CategoryRepo;
import com.selectivegames.main.selectivegames.repository.DlrRepo;
import com.selectivegames.main.selectivegames.repository.GameRepo;
import com.selectivegames.main.selectivegames.repository.LoggingRepo;
import com.selectivegames.main.selectivegames.repository.MessageRepo;
import com.selectivegames.main.selectivegames.repository.ServiceInfoRepo;
import com.selectivegames.main.selectivegames.repository.SubscriptionRepo;

@Service
public class GameService {

	private static Logger logger = LoggerFactory.getLogger(GameService.class);

	@Autowired
	private CommonService commonService;

	@Autowired
	private SubscriptionRepo subRepo;

	@Autowired
	private ServiceInfoRepo serviceInfoRepo;

	@Value("${data.status}")
	private int status;

	@Autowired
	private LoggingRepo loggingRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private GameRepo gameRepo;

	@Autowired
	private DlrRepo dlrRepo;

	@Autowired
	private MessageRepo messageRepo;

	public List<Category> getCategoryList() {
		return categoryRepo.findByStatus(status);
	}

	public Category getCategoryDetails(Long id) {
		return categoryRepo.findById(id).get();
	}

	public Game getGameDetails(Long id) {
		return gameRepo.findById(id).get();
	}

	public List<Game> getGameByCategoryId(Long id) {
		Category category = categoryRepo.findById(id).get();
		return gameRepo.findByCategoryAndStatus(category, status);
	}

	public DLR addToDLR(DLR dlr) {
		dlr.setAni(commonService.parseMSIDN(dlr.getTelNo()));
		dlr.setDatetime(LocalDateTime.now());
		return dlrRepo.save(dlr);
	}

	public LocalDateTime converStringDateTimeTOLocalDateTime(String datetime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(datetime, formatter);
	}

	public void addRedirectLogging(RedirectDataModel model) {
		addToLogger(commonService.objToJson(model), model.getRc(), model.getTn(), LogType.Redirect);
	}

	public void addToLogger(String data, String status, Long ani, LogType logType) {
		loggingRepo.save(new Logging(ani, logType, status, data, LocalDateTime.now()));
	}

	public String getMessage(int scope) {
		return messageRepo.findById(scope).get().getMessage();
	}

	public String getServiceName(String clientName) {
		return serviceInfoRepo.findByClientName(clientName).getServiceName();
	}

	public Subscription callSubscritionCheck(String service, Long ani) {
		return subRepo.getSubscriberCount(ani, LocalDateTime.now(), service);
	}

	public RedirectDataModel updateDate(RedirectDataModel model) {
		model.setTn(commonService.parseMSIDN(model.getTn()));
		return model;
	}
}
