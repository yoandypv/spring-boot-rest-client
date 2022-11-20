package com.yoandypv.restclientsamples.service;

import com.yoandypv.restclientsamples.service.dto.team.TeamResponse;

public interface TeamService {
  TeamResponse findAll(String token);
}
