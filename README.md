# GRAD001 - LUNGAMALINGA - ASSESSMENT PROJECT


# URL
> URL : http://localhost:8080

# ************** RECYCLING TIPS *********** 

### GET ALL RECYCLING TIPS [GET REQUEST]
> _**/tips/all**_

### GET ONE Tip by ID [tip id is an integer]
> _**/tips/{tip_id}**_

### SAVE/CREATE NEW TIP [POST REQUEST]
> _**/tips/save/tip**_
>   <br>  body example [id is auto incremented no need to include it]:  
    _{ "category_id": 12, "tip_description": "Dont litter on the floor - PLEASE!!!" }_

### DELETE TIP [POST REQUEST]
> **_/tips/delete/tip_**
<br> body example: _{ "id": 9 }_

### UPDATE A TIP RECORD [POST REQUEST]
> **_/tips/update/tip_**
<br> body example: {"id": 2,"category_id": 44,"tip_description": "my name is lunga malinga"}


# ************** DISPOSAL GUIDELINES ***********
### GET ALL DISPOSAL GUIDELINES [GET REQUEST]
> **_/disposalguidelines/all_**

### GET ONE DISPOSAL GUIDELINES BY ID [id is an integer]
> /disposalguidelines/{id}


### DELETE DISPOSAL GUIDELINE BY ID [POST REQUEST]
> _**/disposalguidelines/delete/disposalguideline**_
<br> body example: { "id": 1}

### save disposal guideline [post request]
> **_/disposalguidelines/save/disposalguideline_**
<br> body example: _{"category_id": 2,"instructions": "Be good to the environment"}_

### update disposal guideline [post request]
> **_/disposalguidelines/update/disposalguideline_**
<br> body example: {"id": 1,"category_id": 9510,"instructions": "fight global warming with your hands."}

# ************** WASTE CATEGORIES ***********
### Get all 
> **_/wastecategories/all_**

### Get one by id [id is an integer]
> **_/wastecategories/{id}_**

### delete by id [post request]
> **_/wastecategories/delete/wastecategory_**
<br> body example: {"id": 1}

### save [post request]
> **_/wastecategories/save/wastecategory_**
<br> body example: {"name": "Category name 101","description": "Plastic waste"}

### update [post requets]
> **_/wastecategories/update/wastecategory_**
<br> body example: {"id":1, "name": "Category name 101","description": "Plastic waste 101"} 







