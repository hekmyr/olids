{
    'name': 'Product Custom Fields', # Only required field
    'category': 'Sales',
    'license': 'LGPL-3',
    'depends': [
        'product',
        'sale_management',
        'website_sale'
    ],
    'data': [
        'views/product_template_view.xml',
        'views/sale_order_view.xml'
    ],
    'installable': True,
    'application': True,
}
