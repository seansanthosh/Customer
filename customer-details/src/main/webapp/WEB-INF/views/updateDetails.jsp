<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Update Customer</title>
   </head>

   <body>
      <h1 style="background-color:lightgreen;">Enter Customer details to update</h1>
   

      <form:form method = "POST" action = "/customer-details/Customer/update" >
         <table>
            <!--tr>
                <td><form:label path = "id">Id of Customer to be updated</form:label></td>
                <td><form:input readonly="true"  path = "id" /></td>
            </tr-->
            <form:hidden path="id" />
           <tr>
                  <td><form:label path = "firstName">First Name</form:label></td>
                  <td><form:input path = "firstName" /></td>
               </tr>
               <tr>
                  <td><form:label path = "lastName">Last Name</form:label></td>
                  <td><form:input path = "lastName" /></td>
               </tr>
            <tr>
                  <td><form:label path = "email">Email</form:label></td>
                  <td><form:input path = "email" /></td>
               </tr>

            <tr>
               <td></td>
               <td>
                  <input type = "submit" value = "Save"/>
               </td>
            </tr>
         </table>
      </form:form>
      <br>

      <a href="/customer-details/Customer/show">Back to List</a>
   </body>

</html>