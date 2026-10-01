function validateForm()
{
    // Get Values
    var name = document.getElementById("name").value.trim();
    var email = document.getElementById("email").value.trim();
    var mobile = document.getElementById("mobile").value.trim();
    var dob = document.getElementById("dob").value;
    var qualification = document.getElementById("qualification").value;
    var department = document.getElementById("department").value;
    var experience = document.getElementById("experience").value;
    var jobrole = document.getElementById("jobrole").value;
    var location = document.getElementById("location").value;
    var address = document.getElementById("address").value.trim();
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var resume = document.getElementById("resume").value;
    var terms = document.getElementById("terms").checked;

    // Regular Expressions
    var namePattern = /^[A-Za-z ]+$/;
    var emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    var mobilePattern = /^[0-9]{10}$/;
    var passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$/;

    // Name
    if(name=="")
    {
        alert("Enter your Name");
        return false;
    }

    if(!namePattern.test(name))
    {
        alert("Name should contain only alphabets");
        return false;
    }

    // Email
    if(email=="")
    {
        alert("Enter Email");
        return false;
    }

    if(!emailPattern.test(email))
    {
        alert("Invalid Email Address");
        return false;
    }

    // Mobile
    if(mobile=="")
    {
        alert("Enter Mobile Number");
        return false;
    }

    if(!mobilePattern.test(mobile))
    {
        alert("Mobile Number must contain 10 digits");
        return false;
    }

    // DOB
    if(dob=="")
    {
        alert("Select Date of Birth");
        return false;
    }

    // Age Validation (18+)
    var birthDate = new Date(dob);
    var today = new Date();
    var age = today.getFullYear() - birthDate.getFullYear();

    if(age < 18)
    {
        alert("Candidate must be at least 18 years old");
        return false;
    }

    // Gender
    var gender = document.getElementsByName("gender");
    var selected = false;

    for(var i=0;i<gender.length;i++)
    {
        if(gender[i].checked)
        {
            selected=true;
        }
    }

    if(!selected)
    {
        alert("Select Gender");
        return false;
    }

    // Qualification
    if(qualification=="")
    {
        alert("Select Qualification");
        return false;
    }

    // Department
    if(department=="")
    {
        alert("Select Department");
        return false;
    }

    // Experience
    if(experience=="")
    {
        alert("Select Experience");
        return false;
    }

    // Skills
    var skills=document.getElementsByName("skill");
    var skillSelected=false;

    for(var i=0;i<skills.length;i++)
    {
        if(skills[i].checked)
        {
            skillSelected=true;
        }
    }

    if(!skillSelected)
    {
        alert("Select at least one Skill");
        return false;
    }

    // Job Role
    if(jobrole=="")
    {
        alert("Select Preferred Job Role");
        return false;
    }

    // Location
    if(location=="")
    {
        alert("Select Preferred Location");
        return false;
    }

    // Address
    if(address=="")
    {
        alert("Enter Address");
        return false;
    }

    // Password
    if(password=="")
    {
        alert("Enter Password");
        return false;
    }

    if(!passwordPattern.test(password))
    {
        alert("Password must contain:\n\nMinimum 8 characters\nOne Uppercase Letter\nOne Lowercase Letter\nOne Number\nOne Special Character");
        return false;
    }

    // Confirm Password
    if(confirmPassword=="")
    {
        alert("Confirm your Password");
        return false;
    }

    if(password!=confirmPassword)
    {
        alert("Passwords do not match");
        return false;
    }

    // Resume
    if(resume=="")
    {
        alert("Upload Resume");
        return false;
    }

    var extension = resume.split('.').pop().toLowerCase();

    if(extension!="pdf" && extension!="doc" && extension!="docx")
    {
        alert("Upload only PDF, DOC or DOCX file");
        return false;
    }

    // Terms
    if(!terms)
    {
        alert("Please accept Terms & Conditions");
        return false;
    }

    alert("🎉 Registration Successful!");

    return true;
}