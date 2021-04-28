<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/Weather/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Weather/jquery.pagination.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/Weather/weather.js?2020042602"></script>


<form:form  modelAttribute="weEntity" >
		
<form:hidden path="cityListJson" />
		
    <table width="30%"  align='center' border='1' cellspacing='2'>
    
        <tr>
            <td>City</td>
           
            <td>
            <select style="width:100%;" onchange="return cityChange(this.options[this.options.selectedIndex].value)" name="citySelect" id="citySelect">
						<option value="none">Please Choose City</option>
			</select>
            </td>
        </tr>
         <tr>
            <td>Updated time</td>
            
            <td>
            <input style="width:98%;" type="text" name="updatetime" class="ds-input "
				   id="updatetime" placeholder="">
            </td>
        </tr>
         <tr>
            <td>Weather</td>
            
            <td>
            <input style="width:98%;" type="text" name="weather" class="ds-input "
				   id="weather" placeholder="">
            </td>
        </tr>
        <tr>
            <td>Temperature</td>
            
            <td>
            <input style="width:98%;" type="text" name="temperature" class="ds-input "
				   id="temperature" placeholder="">
            </td>
        </tr>
        <tr>
            <td>Wind</td>
            
            <td>
            <input style="width:98%;" type="text" name="wind" class="ds-input "
				   id="wind" placeholder="">
            </td>
        </tr>
        
         
    </table>
    
</form:form>
   