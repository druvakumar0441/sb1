package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.course;
import com.example.entity.passport;
import com.example.entity.person;
import com.example.entity.simcard;
import com.example.repo.courseRepo;
import com.example.repo.passportRepo;
import com.example.repo.personRepo;
import com.example.repo.simcardRepo;

@RestController
@RequestMapping("sb1controller")
public class insertDao implements ErrorController{

	private final static String PATH = "/error";
	 	@RequestMapping(PATH)
	    @ResponseBody
	    public String getErrorPath() {
	       
	        return "No Mapping Found";
	    }
	@Autowired
	private personRepo prepo;
	@Autowired
	private courseRepo crepo;
	@Autowired
	private simcardRepo srepo;
	@Autowired
	private passportRepo pprepo;
	
	@PostMapping("/one")
	public void save() {
	
		person p= new person("shiva", 32,"delhi");
		person p1= new person("chinna", 33,"goa");
		person p2= new person("srinu", 55,"goa");
		person p3= new person("ajay", 33,"kerala");
		
		simcard sc = new simcard(); sc.setSname("docomo"); sc.setSnum(434343);sc.setP(p3);
		 simcard sc1 = new simcard(); sc1.setSname("uninor"); sc1.setSnum(343434);sc1.setP(p3);
		 simcard sc3 = new simcard(); sc3.setSname("idea"); sc3.setSnum(454544);sc3.setP(p3);
		 simcard sc2 = new simcard(); sc2.setSname("airtel"); sc2.setSnum(434343);sc2.setP(p1);
		 simcard sc4 = new simcard(); sc4.setSname("uninor"); sc4.setSnum(343434);sc4.setP(p1);
		 simcard sc5 = new simcard(); sc5.setSname("idea"); sc5.setSnum(454544);sc5.setP(p1);
		 simcard sc6= new simcard(); sc6.setSname("jio"); sc6.setSnum(434343);sc6.setP(p2);
		 simcard sc7 = new simcard(); sc7.setSname("airtel"); sc7.setSnum(343434);sc7.setP(p2);
		 simcard sc8 = new simcard(); sc8.setSname("idea"); sc8.setSnum(454544);sc8.setP(p2);
		 simcard sc9= new simcard(); sc9.setSname("bsnl"); sc9.setSnum(434343);sc9.setP(p);
		 simcard sc10 = new simcard(); sc10.setSname("jio"); sc10.setSnum(343434);sc10.setP(p);
		 simcard sc11 = new simcard(); sc11.setSname("docomo"); sc11.setSnum(454544);sc11.setP(p);
	
		passport pp = new passport();pp.setP(p);pp.setPnum("343dfv");pp.setP(p);
		passport pp1 = new passport();pp1.setP(p1);pp1.setPnum("343dfv");pp1.setP(p1);
		passport pp2 = new passport();pp2.setP(p2);pp2.setPnum("343dfv");pp2.setP(p2);
		passport pp3 = new passport();pp3.setP(p3);pp3.setPnum("343dfv");pp3.setP(p3);
		
		List<person> lp = new ArrayList<>(Arrays.asList(p, p1,p2,p3));
		List<person> lp1 = new ArrayList<>(Arrays.asList(p2,p3));
		List<person> lp2 = new ArrayList<>(Arrays.asList(p, p1));
		
		course c = new course();c.setCname("java");c.setP(lp2);
		course c1 = new course();c1.setCname("python");c1.setP(lp);
		course c2 = new course();c2.setCname("aws");c2.setP(lp1);
		
		List<course> cc = new ArrayList<>(Arrays.asList(c,c1,c2));
		List<simcard> ss = new ArrayList<>(Arrays.asList(sc,sc1,sc2,sc3,sc4,sc5,sc6,sc7,sc8,sc9,sc10,sc11));
		List<passport> ppp = new ArrayList<>(Arrays.asList(pp, pp1,pp2,pp3));
		System.out.println("inserting");
		prepo.saveAll(lp);
		pprepo.saveAll(ppp);
		srepo.saveAll(ss);
		crepo.saveAll(cc);
		System.out.println("completed");
	}
	
	@PostMapping("/save1")
	public void save1() {
		System.out.println("start");
		person p= new person("fqq", 32,"ben");
		person p1= new person("aaa", 50,"hyd");
		person p2= new person("zzzz", 55,"pat");
		person p3= new person("ccc", 80,"mys");
		List<person> lp = new ArrayList<>(Arrays.asList(p, p1,p2,p3));
		prepo.saveAll(lp);
		System.out.println("done");
	}
	@GetMapping("/gi")
	public void getDataById(@RequestParam Integer id) {
		person p=prepo.getById(id);
		System.out.println(p);
		
	}
	@GetMapping("/g")
	public void getData(@RequestParam String pname) {
		person p=prepo.getByName(pname);
		System.out.println(p);
	}
	@DeleteMapping("/d")
	public void deleteData(@RequestParam int id) {
		prepo.deleteById(id);
	}
	@PutMapping("/put")
	public void putData(@RequestBody person person) {
		prepo.save(person);
	}
	 @PatchMapping("/patch")
	    public void patchData(@RequestBody person person) {
	        if (person != null) {
	            person existingPerson = prepo.findById(person.getPid()).orElse(null);
	            if (existingPerson != null) {
	                if (person.getPname() != null) {
	                    existingPerson.setPname(person.getPname());
	                }
	                if (person.getPaddress() != null) {
	                    existingPerson.setPaddress(person.getPaddress());
	                }
	                prepo.save(existingPerson); // Save the updated person object
	            } else {
	                System.out.println("Person with id " + person.getPid() + " does not exist");
	            }
	        } else {
	            System.out.println("Request body is empty or invalid");
	        }
	    }
	 @GetMapping("/all")
		public void getAll() {
			List<person> list=prepo.findAll();
			for (person person : list) {
				System.out.println(person);
			}
		}
	
}
