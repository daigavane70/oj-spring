package com.sprint.server.controller;


import com.sprint.common.request.ContestRequest;
import com.sprint.common.response.HttpApiResponse;
import com.sprint.common.response.HttpErrorResponse;
import com.sprint.common.utils.Utils;
import com.sprint.repository.entity.Contest;
import com.sprint.repository.repositories.ContestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ContestController {

    @Autowired
    ContestRepository contestRepository;

    @GetMapping("/contest")
    public HttpApiResponse<List<Contest>> getAllContests() {
        try {
            log.info("[ContestController : getAllContests] request of get all contests");
            List<Contest> contests = contestRepository.findAll();
            log.info("[ContestController : getAllContests] returning all contests: {}", contests);
            return new HttpApiResponse<>(contests);
        } catch (Exception e) {
            log.error("[getAllContests] Error: {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }

    @GetMapping("/contest/{id}")
    public HttpApiResponse getContestById(@PathVariable Long id) {
        try {
            log.info("[ContestController : getContestById] request for contests by id: {}", id);
            Optional<Contest> contest = contestRepository.findById(id);
            log.info("[ContestController : getContestById] contest found for id: {}", id);
            if (contest.isEmpty()) {
                throw new Exception("No contest found with id: " + id);
            }
            return new HttpApiResponse<>(contest);
        } catch (Exception e) {
            log.error("[ContestController : getContestById] Error : {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }

    @PostMapping(value = "/contest", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpApiResponse createContest(ContestRequest contestRequest) {
        try {
            log.info("[ContestController : createContest] received request to create contest for payload: {}", contestRequest);
            Contest contestBuilder = Contest.builder()
                    .name(contestRequest.getName())
                    .startTime(Utils.stringToLocalDateTime(contestRequest.getStartTime()))
                    .endTime(Utils.stringToLocalDateTime(contestRequest.getEndTime()))
                    .totalQuestions(contestRequest.getTotalQuestions())
                    .description(contestRequest.getDescription()).build();

            Contest newContest = contestRepository.save(contestBuilder);
            log.info("[ContestController : createContest] new contest created: {}", newContest);
            return new HttpApiResponse<>(newContest);

        } catch (Exception e) {
            log.error("[ContestController : getContestById] Error : {}", e);
            return new HttpApiResponse<>(false, null, new HttpErrorResponse(400, e.getMessage()));
        }
    }
}
