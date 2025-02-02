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
>   <br> request body [example]:  
    _{ "category_id": 12, "tip_description": "Dont litter on the floor - PLEASE!!!" }_

### DELETE TIP [POST REQUEST]
> **_/tips/delete/tip_**
<br> body example: _{ "tip_id": 9 }_

### UPDATE A TIP RECORD [POST REQUEST]
> **_/tips/update/tip_**
<br> body example: {"tip_id": 2,"category_id": 44,"tip_description": "my name is lunga malinga"}


# ************** DISPOSAL GUIDELINES ***********
### GET ALL DISPOSAL GUIDELINES [GET REQUEST]
> **_/disposalguidelines/all_**

### GET ONE DISPOSAL GUIDELINES BY ID [id is an integer]
> /disposalguidelines/{id}


### DELETE DISPOSAL GUIDELINE BY ID [POST REQUEST]
> _**/disposalguidelines/delete/disposalguideline**_
<br> body exampl: { "id": 1}

### save
> **_/disposalguidelines/save/disposalguideline_**
<br> body example: _{"category_id": 2,"instructions": "Be good to the environment"}_

### update









