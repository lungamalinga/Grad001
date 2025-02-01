# GRAD001 - LUNGAMALINGA - ASSESSMENT PROJECT

# URL
> URL : http://localhost:8080

# END POINTS: 

# GET ALL RECYCLING TIPS [GET REQUEST]
> /tips/all

# GET ONE Tip by ID [tip id is an integer]
> tips/{tip_id}

# SAVE/CREATE NEW TIP [POST REQUEST]
> /tips/save/tip
>   <br> request body [example]:  
    { "category_id": 12, "tip_description": "Dont litter on the floor - PLEASE!!!" }

# DELETE TIP [POST REQUEST]
> /tips/delete/tip
<br> body example: { "tip_id": 9 }

# UPDATE A TIP RECORD
> tips/update/tip
<br> body example: {"tip_id": 2,"category_id": 44,"tip_description": "my name is lunga malinga"}










