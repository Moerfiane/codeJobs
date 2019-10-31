package org.CodeJobs.controllers;

import org.CodeJobs.models.*;
import org.CodeJobs.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class AdminEditController {

    @Autowired
    JobDao jobDao;

    @Autowired
    EducationDao educationDao;

    @Autowired
    WorkExperienceDao workExperienceDao;

    @Autowired
    StatementDao statementDao;

    @Autowired
    SkillsDao skillsDao;

    @Autowired
    ProjectExperienceDao projectExperienceDao;

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "edit/job/{jobId}", method = RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int jobId) {

        model.addAttribute("title", "Edit Job");
        model.addAttribute("job", jobDao.findOne(jobId));

        return "adminedit/jobedit";
    }

    @RequestMapping(value = "edit/job/{jobId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int jobId, @ModelAttribute @Valid Job newJob,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "adminedit/jobedit";
        }

        Job editedJob = jobDao.findOne(jobId);
        editedJob.setJobTitle(newJob.getJobTitle());
        editedJob.setAddress(newJob.getAddress());
        editedJob.setJobCategory(newJob.getJobCategory());
        editedJob.setLocation(newJob.getLocation());
        editedJob.setSchedule(newJob.getSchedule());
        editedJob.setJobSummary(newJob.getJobSummary());
        editedJob.setPositionType(newJob.getPositionType());
        editedJob.setNumOfPositions(newJob.getNumOfPositions());
        editedJob.setDressCode(newJob.getDressCode());
        editedJob.setPayRate(newJob.getPayRate());
        editedJob.setClosingDate(newJob.getClosingDate());
        jobDao.save(editedJob);

        return "redirect:/admin/job";
    }

    @RequestMapping(value = "edit/education/{educationId}", method = RequestMethod.GET)
    public String displayAdminEducationEdit(Model model, @PathVariable int educationId) {

        model.addAttribute("title", "Admin: Edit Education");
        model.addAttribute("education", educationDao.findOne(educationId));

        return "adminedit/educationedit";

    }


    @RequestMapping(value = "edit/education/{educationId}", method = RequestMethod.POST)
    public String processAdminEducationEditJobForm(Model model, @PathVariable int educationId,
                                                   @ModelAttribute @Valid Education newEducation,
                                                   Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Admin: Edit Education");
            return "adminedit/educationedit";
        }

        Education editedEducation = educationDao.findOne(educationId);
        editedEducation.setSchoolName(newEducation.getSchoolName());
        editedEducation.setDegree(newEducation.getDegree());
        editedEducation.setStartDate(newEducation.getStartDate());
        editedEducation.setCompletionDate(newEducation.getCompletionDate());
        editedEducation.setCurrent(newEducation.getCurrent());
        educationDao.save(editedEducation);

        return "redirect:/admin/education";

    }


    @RequestMapping(value = "edit/workexperience/{workId}", method = RequestMethod.GET)
    public String displayAdminEditWorkExpForm(Model model, @PathVariable int workId) {

        model.addAttribute("title", "Edit Work Experience");
        model.addAttribute("workExperience", workExperienceDao.findOne(workId));

        return "workexperience/edit";

    }

    @RequestMapping(value = "edit/workexperience/{workId}", method = RequestMethod.POST)
    public String processAdminEditWorkExpForm(Model model, @PathVariable int workId, @ModelAttribute @Valid
            WorkExperience newWorkExperience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Work Experience");
            return "workexperience/edit";
        }

        WorkExperience editedWorkExperience = workExperienceDao.findOne(workId);
        editedWorkExperience.setJobTitle(newWorkExperience.getJobTitle());
        editedWorkExperience.setCompanyName(newWorkExperience.getCompanyName());
        editedWorkExperience.setLocation(newWorkExperience.getLocation());
        editedWorkExperience.setStartDate(newWorkExperience.getStartDate());
        editedWorkExperience.setEndDate(newWorkExperience.getEndDate());
        editedWorkExperience.setCurrent(newWorkExperience.getCurrent());
        editedWorkExperience.setDetail1(newWorkExperience.getDetail1());
        editedWorkExperience.setDetail2(newWorkExperience.getDetail2());
        editedWorkExperience.setDetail3(newWorkExperience.getDetail3());
        workExperienceDao.save(editedWorkExperience);

        return "redirect:/admin/workexperience/";

    }


    @RequestMapping(value = "edit/statement/{statementId}", method = RequestMethod.GET)
    public String displayEditStatementForm(Model model, @PathVariable int statementId) {

        model.addAttribute("title", "Edit Statement");
        model.addAttribute("statement", statementDao.findOne(statementId));

        return "adminedit/statementedit";

    }

    @RequestMapping(value = "edit/statement/{statementId}", method = RequestMethod.POST)
    public String processStatementForm(Model model, @PathVariable int statementId, @ModelAttribute
    @Valid Statement newStatement, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Statement");
            return "adminedit/statementedit";
        }

        Statement editedStatement = statementDao.findOne(statementId);
        editedStatement.setDescription(newStatement.getDescription());
        statementDao.save(editedStatement);

        return "redirect:/admin/statement/";

    }

    @RequestMapping(value="edit/skills/{skillsId}", method=RequestMethod.GET)
    public String displayAdminSkillEditJobForm(Model model, @PathVariable int skillsId) {

        model.addAttribute("title", "Admin: Edit Skills");
        model.addAttribute("skills", skillsDao.findOne(skillsId));

        return "adminedit/skillsedit";
    }

    @RequestMapping(value="edit/skills/{skillsId}", method = RequestMethod.POST)
    public String processAdminSkillEditForm(Model model, @PathVariable int skillsId, @ModelAttribute  @Valid Skills newSkills,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Admin: Edit Skills");
            return "adminedit/skillsedit";
        }

        Skills editedSkills = skillsDao.findOne(skillsId);
        editedSkills.setLanguage1(newSkills.getLanguage1());
        editedSkills.setLanguage2(newSkills.getLanguage2());
        editedSkills.setLanguage3(newSkills.getLanguage3());
        editedSkills.setLanguage4(newSkills.getLanguage4());
        editedSkills.setLanguage5(newSkills.getLanguage5());
        editedSkills.setLanguage6(newSkills.getLanguage6());
        editedSkills.setFramework1(newSkills.getFramework1());
        editedSkills.setFramework2(newSkills.getFramework2());
        editedSkills.setFramework3(newSkills.getFramework3());
        editedSkills.setFramework4(newSkills.getFramework4());
        editedSkills.setFramework5(newSkills.getFramework5());
        editedSkills.setFramework6(newSkills.getFramework6());
        editedSkills.setDatabase1(newSkills.getDatabase1());
        editedSkills.setDatabase2(newSkills.getDatabase2());
        editedSkills.setDatabase3(newSkills.getDatabase3());
        editedSkills.setTool1(newSkills.getTool1());
        editedSkills.setTool2(newSkills.getTool2());
        editedSkills.setTool3(newSkills.getTool3());

        skillsDao.save(editedSkills);

        return "redirect:/admin/skills";
    }

    @RequestMapping(value="edit/projectexperience/{projectExperienceId}", method=RequestMethod.GET)
    public String displayAdminProjectExperienceEditJobForm(Model model, @PathVariable int projectExperienceId) {

        model.addAttribute("title", "Admin: Edit Skills");
        model.addAttribute("projectExperience", projectExperienceDao.findOne(projectExperienceId));

        return "adminedit/projectexperienceedit";
    }

    @RequestMapping(value="edit/projectexperience/{projectExperienceId}", method = RequestMethod.POST)
    public String processAdminProjectExperienceEditForm(Model model, @PathVariable int projectExperienceId,
                                                        @ModelAttribute @Valid ProjectExperience newProjectExperience,
                                                        Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Admin: Edit Project Experience");
            return "adminedit/projectexperienceedit";
        }

        ProjectExperience editedProjectExperience = projectExperienceDao.findOne(projectExperienceId);
        editedProjectExperience.setName(newProjectExperience.getName());
        editedProjectExperience.setSummary(newProjectExperience.getSummary());
        editedProjectExperience.setDetail1(newProjectExperience.getDetail1());
        editedProjectExperience.setDetail2(newProjectExperience.getDetail2());
        editedProjectExperience.setDetail3(newProjectExperience.getDetail3());
        projectExperienceDao.save(editedProjectExperience);

        return "redirect:/admin/projectexperience";
    }

    @RequestMapping(value="edit/users/{usersUid}", method = RequestMethod.GET)
    public String displayAdminUserEditForm(Model model, @PathVariable int usersUid) {

        model.addAttribute("title", "Admin: Edit Users");
        model.addAttribute("users", userDao.findOne(usersUid));

        return "adminedit/usersedit";
    }

    @RequestMapping(value="edit/users/{usersUid}", method = RequestMethod.POST)
    public String processAdminUserEditForm(Model model, @PathVariable int usersUid,
                                                        @ModelAttribute User newUser) {

        User editedUser = userDao.findOne(usersUid);
        editedUser.setUsername(newUser.getUsername());
        editedUser.setAccess(newUser.getAccess());
        userDao.save(editedUser);

        return "redirect:/admin/users";
    }

}
