package com.jiaoshen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiaoshen.dto.Exposer;
import com.jiaoshen.dto.SeckillExecution;
import com.jiaoshen.dto.SeckillResult;
import com.jiaoshen.enpty.Seckill;
import com.jiaoshen.enums.SeckillStatEnum;
import com.jiaoshen.exception.RepeatKillException;
import com.jiaoshen.exception.SeckillCloseException;
import com.jiaoshen.service.SeckillService;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author jiaoshen
 * @date   2018��1��6��
 */
@Controller 
@RequestMapping("/seckill")
public class SeckillController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SeckillService seckillService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String 	List(Model model){
		//��ȡ�б�ҳ
		List<Seckill> list=seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
		
	}
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String 	detail(@PathVariable("seckillId") Long seckillId,Model model){
		//��ȡ�б�ҳ
		if(seckillId == null){
			return "reditrect:/seckill/list";
		}
		Seckill seckill=seckillService.getById(seckillId);
		if(seckill == null){
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
		
	}
	
	//ajax json 
	@RequestMapping(value="/{seckillId}/exposer"
			,method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> 	exposer(@PathVariable("seckillId")Long seckillId){
		 SeckillResult<Exposer>  result;
		try{
			Exposer exposer=seckillService.exportSeckillUrl(seckillId);
			result =new SeckillResult<Exposer>(true,exposer);			
		}
		catch(Exception e){
			logger.error(e.getMessage(),e);
			result=new SeckillResult<Exposer>(false,e.getMessage());
		}
		return result;
	}
	
	/**
	 * @param seckillId
	 * @param md5
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/{seckillId}/{md5}/execution"
			,method=RequestMethod.POST,
			produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> 	execute(@PathVariable("seckillId")Long seckillId,@PathVariable("md5")String md5,@CookieValue(value="killPhone",required = false)String phone){
		if(phone==null){
			return new SeckillResult<SeckillExecution>(false, "no resiger");
		}
		SeckillResult<SeckillExecution> result;
		try{
			SeckillExecution exection= seckillService.executeSeckill(seckillId, phone, md5);
			return new SeckillResult<SeckillExecution>(true, exection);
		}catch(RepeatKillException e){
			SeckillExecution execution=new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExecution>(true, execution);
		}catch(SeckillCloseException e){
			SeckillExecution execution=new SeckillExecution(seckillId, SeckillStatEnum.END);
			return new SeckillResult<SeckillExecution>(true, execution);
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			SeckillExecution execution=new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
			return new SeckillResult<SeckillExecution>(true, execution);
		}
	}
	@RequestMapping(value="/time/now", method =RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time(){
		Date now = new Date();
		return new SeckillResult<Long>(true, now.getTime());
	}
}
