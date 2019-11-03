package org.CodeJobs.controllers;

import org.CodeJobs.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.CodeJobs.models.data.*;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private StatementDao statementDao;

    @Autowired
    private SkillsDao skillsDao;

    @Autowired
    private ProjectExperienceDao projectExperienceDao;

    @Autowired
    private WorkExperienceDao workExperienceDao;

    @Autowired
    private EducationDao educationDao;

    @Autowired
    private NewApplicantDao newApplicantDao;

    @RequestMapping(value = "")
    public String index(Model model, HttpSession session) {
        Integer user = (Integer) session.getAttribute("user_id");
        System.out.println(user + "new");
        model.addAttribute("statements", (statementDao.findOne(user)));
        model.addAttribute("skills", (skillsDao.findOne(user)));
        model.addAttribute("projectExperiences", (projectExperienceDao.findOne(user)));
        model.addAttribute("workExperiences", (workExperienceDao.findOne(user)));
        model.addAttribute("educations", (educationDao.findOne(user)));
        model.addAttribute("newApplicants", (newApplicantDao.findOne(user)));

        return "resume/index";
    }
        @RequestMapping(value = "final")
        public String processFinal (Model model, HttpSession session){
            Integer user = (Integer) session.getAttribute("user_id");
            System.out.println(user + "new");
            model.addAttribute("statements", (statementDao.findOne(user)));
            model.addAttribute("skills", (skillsDao.findOne(user)));
            model.addAttribute("projectExperiences", (projectExperienceDao.findOne(user)));
            model.addAttribute("workExperiences", (workExperienceDao.findOne(user)));
            model.addAttribute("educations", (educationDao.findOne(user)));
            model.addAttribute("newApplicants", (newApplicantDao.findOne(user)));

            return "resume/final";
        }

    @RequestMapping(value = "editstatement/{statementId}", method = RequestMethod.GET)
    public String displayEditStatementForm(Model model, @PathVariable int statementId) {

        model.addAttribute("title", "Edit Statement");
        model.addAttribute("statement", statementDao.findOne(statementId));

        return "resume/editstatement";

    }

    @RequestMapping(value = "editstatement/{statementId}", method = RequestMethod.POST)
    public String processStatementForm(Model model, @PathVariable int statementId, @ModelAttribute
    @Valid Statement newStatement, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Statement");
            return "resume/editstatement";
        }

        Statement editedStatement = statementDao.findOne(statementId);
        editedStatement.setDescription(newStatement.getDescription());
        statementDao.save(editedStatement);

        return "redirect:/resume";
    }
    @RequestMapping(value="editskills/{skillsId}", method=RequestMethod.GET)
    public String displayEditJobForm(Model model, @PathVariable int skillsId) {

        model.addAttribute("title", "Edit Skill");
        model.addAttribute("skills", skillsDao.findOne(skillsId));

        return "resume/editskills";
    }

    @RequestMapping(value="editskills/{skillsId}", method = RequestMethod.POST)
    public String processEditForm(Model model, @PathVariable int skillsId, @ModelAttribute  @Valid Skills newSkills,
                                  Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "resume/editskills";
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

        return "redirect:/resume";
    }

    @RequestMapping(value = "editprojectexperience/{projectExperienceId}", method = RequestMethod.GET)
    public String displayEditProjectExperienceForm(Model model, @PathVariable int projectExperienceId) {

        model.addAttribute("title", "Edit Project");
        model.addAttribute("projectExperience", projectExperienceDao.findOne(projectExperienceId));

        return "resume/editprojectexperience";

    }

    @RequestMapping(value = "editprojectexperience/{projectExperienceId}", method = RequestMethod.POST)
    public String processEditProjectExperienceForm(Model model, @PathVariable int projectExperienceId, @ModelAttribute @Valid
            ProjectExperience projectExperience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Project");
            return "resume/editprojectexperience";
        }

        ProjectExperience editedProject = projectExperienceDao.findOne(projectExperienceId);
        editedProject.setName(projectExperience.getName());
        editedProject.setSummary(projectExperience.getSummary());
        editedProject.setDetail1(projectExperience.getDetail1());
        editedProject.setDetail2(projectExperience.getDetail2());
        editedProject.setDetail3(projectExperience.getDetail3());
        projectExperienceDao.save(editedProject);

        return "redirect:/resume";

    }

    @RequestMapping(value = "editworkexperience/{workId}", method = RequestMethod.GET)
    public String displayEditWorkExpForm(Model model, @PathVariable int workId) {

        model.addAttribute("title", "Edit Work Experience");
        model.addAttribute("workExperience", workExperienceDao.findOne(workId));

        return "resume/editworkexperience";

    }

    @RequestMapping(value = "editworkexperience/{workId}", method = RequestMethod.POST)
    public String processEditWorkExpForm(Model model, @PathVariable int workId, @ModelAttribute @Valid
            WorkExperience newWorkExperience, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Work Experience");
            return "resume/editworkexperience";
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

        return "redirect:/resume";


    }

    @RequestMapping(value = "editeducation/{educationId}", method = RequestMethod.GET)
    public String displayEducationForm(Model model, @PathVariable int educationId) {

        model.addAttribute("title", "Edit Education");
        model.addAttribute("education", educationDao.findOne(educationId));

        return "resume/editeducation";

    }


    @RequestMapping(value = "editeducation/{educationId}", method = RequestMethod.POST)
    public String processEducationForm(Model model, @PathVariable int educationId, @ModelAttribute @Valid Education newEducation,
                                     Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Education");
            return "resume/editeducation";
        }

        Education editedEducation = educationDao.findOne(educationId);
        editedEducation.setSchoolName(newEducation.getSchoolName());
        editedEducation.setDegree(newEducation.getDegree());
        editedEducation.setStartDate(newEducation.getStartDate());
        editedEducation.setCompletionDate(newEducation.getCompletionDate());
        editedEducation.setCurrent(newEducation.getCurrent());
        educationDao.save(editedEducation);

        return "redirect:/resume";
    }

    @RequestMapping(value = "editnewapplicant/{newApplicantId}", method = RequestMethod.GET)
    public String displayNewApplicantForm(Model model, @PathVariable int newApplicantId) {

        model.addAttribute("title", "Edit Applicant");
        model.addAttribute("newApplicant", newApplicantDao.findOne(newApplicantId));

        return "resume/editnewapplicant";

    }

    @RequestMapping(value = "editnewapplicant/{newApplicantId}", method = RequestMethod.POST)
    public String processEditNewApplicantForm(Model model, @PathVariable int newApplicantId, @ModelAttribute @Valid
            NewApplicant newApplicant, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Applicant");
            return "resume/editnewapplicant";
        }

        NewApplicant editedApplicant = newApplicantDao.findOne(newApplicantId);
        editedApplicant.setGitHub(newApplicant.getGitHub());
        editedApplicant.setLinkedIn(newApplicant.getLinkedIn());
        editedApplicant.setName(newApplicant.getName());
        editedApplicant.setPhoneNum(newApplicant.getPhoneNum());
        editedApplicant.setEmail(newApplicant.getEmail());
        newApplicantDao.save(editedApplicant);

        return "redirect:/resume";

    }
}

