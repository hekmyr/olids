from odoo import models, fields

class User(models.Model):
    _inherit = "res.partner"

    password = fields.Char("Password")
