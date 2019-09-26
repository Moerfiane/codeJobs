package org.stlyouthjobs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stlyouthjobs.models.CommunityInvolvement;
import org.stlyouthjobs.models.data.CommunityInvolvementDao;

@Controller
@RequestMapping("communityInvolvement")
public class CommunityInvolvementController {

    @Autowired
    private CommunityInvolvementDao communityInvolvementDao;
}
