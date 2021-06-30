package com.tweetApp.FSE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.FSE.TwitterApplication;
import com.tweetApp.FSE.DTO.ReplyDTO;
import com.tweetApp.FSE.DTO.TweetRequestDTO;
import com.tweetApp.FSE.DTO.TweetResponseDTO;
import com.tweetApp.FSE.DTO.UserTweetsDTO;
import com.tweetApp.FSE.Service.TweetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "TwitterManagement" })
@RestController
@RequestMapping(value = "/api/v1.0/tweets")
//@Slf4j
public class TweetController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TwitterApplication.class);
	@Autowired
	TweetService tweetService;

	//private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TweetController.class);
	
	@ApiOperation(value = "Post tweet", response = String.class, notes = "This API used to post loggedin users tweet."
			+ "and return success message")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/posttweet")
	public String postTweet(@RequestBody TweetRequestDTO tweetRequest) {
		log.info(" Entering postTweet ");
		String message = tweetService.postTweet(tweetRequest);
		log.info("Tweet Post message {} ",message);
		
		return message;
	}

	
	
	@ApiOperation(value = "Get tweet", response = TweetResponseDTO.class, notes = "This API used to get all loggedin users tweets."
			+ "and return all logged in users tweets")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@GetMapping("/gettweets")
	public ResponseEntity<List<TweetResponseDTO>> getAllTweets() {
		log.info(" Entering getAllTweets ");
		return ResponseEntity.ok().body(tweetService.getAllTweets());
	}

	
	
	@ApiOperation(value = "Reply tweet", response = String.class, notes = "This API used to reply to users tweet."
			+ "and return success message")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/reply")
	public String postReply(@RequestBody ReplyDTO replyDTO) {
		log.info(" Entering postreply ");
		String message = tweetService.postReply(replyDTO);
		log.info(" Post reply message {} ",message);
		return message;
	}

	
	
	@ApiOperation(value = "Delete tweet", response = String.class, notes = "This API used to delete loggedin users tweet."
			+ "and return success message")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@DeleteMapping("/delete")
	public String deleteTweet(@RequestParam("tweetId") int tweetId) {
		log.info("Entering into deleteTweet. TweetId : {}  ", tweetId);
		String message = tweetService.deleteTweet(tweetId);
		log.info("Exit deletTweet. Tweet Delete message: {} ",message);
		return message;

	}
}
