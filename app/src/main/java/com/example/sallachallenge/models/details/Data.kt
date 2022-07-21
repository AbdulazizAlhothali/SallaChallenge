package com.example.sallachallenge.models.details

/*
Copyright (c) 2022 Kotlin com.example.sallachallenge.models.details.Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Data (

    val id : Int,
    val promotion : Promotion,
    val sku : String,
    val mpn : String,
    val gtin : String,
    val type : String,
    val name : String,
    val short_link_code : String,
    val urls : Urls,
    val price : Price,
    val taxed_price : Taxed_price,
    val pre_tax_price : Pre_tax_price,
    val tax : Tax,
    val description : String,
    val quantity : Int,
    val status : String,
    val is_available : Boolean,
    val views : String,
    val sale_price : Sale_price,
    val sale_end : String,
    val require_shipping : Boolean,
    val cost_price : Double,
    val weight : Int,
    val weight_type : String,
    val weight_label : String,
    val with_tax : Boolean,
    val included_tax : Boolean,
    val url : String,
    val main_image : String,
    val images : List<Images>,
    val show_purchase_count : Boolean,
    val sold_quantity : Int,
    val sold_quantity_desc : String,
    val rating : Rating,
    val favorite : String,
    val has_special_price : Boolean,
    val regular_price : Regular_price,
    val features : Features,
    val max_items_per_user : Int,
    val maximum_quantity_per_order : String,
    val show_in_app : Boolean,
    val has_size_guide : Boolean,
    val notify_quantity : String,
    val hide_quantity : Boolean,
    val unlimited_quantity : Boolean,
    val managed_by_branches : Boolean,
    val services_blocks : Services_blocks,
    val calories : String,
    val starting_price : String,
    val options : List<String>,
    val skus : List<String>,
    val tags : List<String>,
    val brand : Brand
)