//validate trainee add form
$(document).ready(function () {
  var now = new Date();

  var day = ("0" + now.getDate()).slice(-2);
  var month = ("0" + (now.getMonth() + 1)).slice(-2);

  var today = now.getFullYear()+"-"+(month)+"-"+(day) ;

  $('#date').val(today);

    jQuery.validator.addMethod("phonenumber", function (value, element) {
        if (/^[0]\d{2}-?\d{3}-?\d{4}$/g.test(value)) {
          return true;
        } else {
          return false;
        }
      });
      // jQuery.validator.addMethod("password", function (value, element) {
      //   if (/^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/g.test(value)) {
      //     return true;
      //   } else {
      //     return false;
      //   }
      // });
  $.validator.addMethod("maxDate", function(value, element) {
        var curDate = new Date();
        var inputDate = new Date(value);
        if (inputDate < curDate)
        return true;
        return false;
  }, "Date must be in past");
    $("#frm-add-trainee").validate({
      onfocusout: false,
      onkeyup: false,
      onclick: false,
      rules: {
        email: {
          required: true,
          email: true
        },
        account: {
          required: true
        },

          fullName: {
            required: true,
            minlength: 8,
            maxlength: 30,
          },
          // password: {
          //   required: true,
          //   password:true
          // },
          phoneNumber: {
            required: true,
            phonenumber: true
          },
          recInterviewDate: {
            required: true
          },
          recInterviewStatus: {
            required: true
          },
          university: {
            required: true
          }
      },
      messages: {
        email: {
          required: "Email is required",
          email: "Email invalid",
        },
        account: {
            required: "Account is required"
          },
        fullName: {
          required: "Full name is required",
          minlength: "Min at least 8 characters",
          maxlength: "Max at least 30 characters",
        },
        // password: {
        //     required: "Password is required",
        //     password: "Password must be at least 8 characters include one upper case, one lower case, one digit,one special character "
        //   },
          phoneNumber: {
            required: "Phone number is required",
            phonenumber: "Phone number must be start with 0 and 9 number"
          },
          university: {
            required: "University is required"
          },
          recInterviewDate: {
            required: "Rec interview date department is required"
          },
          recInterviewStatus: {
            required: "Rec interview status date department is required"
          }
      },
    });
});

