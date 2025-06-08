from odoo import fields, models

class Reservation(models.Model):
    _inherit = 'sale.order.line'

    date_stay_begin = fields.Datetime('Begining date')
    date_stay_end = fields.Datetime('Ending date')
