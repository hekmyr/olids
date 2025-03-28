import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccordionComponent } from '../../components/accordion/accordion.component';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { RouterLink } from '@angular/router';

interface FaqItem {
  question: string;
  answer: string;
}

@Component({
  selector: 'app-faq-page',
  standalone: true,
  imports: [CommonModule, AccordionComponent, MenubarComponent, RouterLink],
  template: `
    <app-menubar />
    <div
      class="flex justify-center bg-alternative px-page pt-page pb-page min-h-screen">
      <div class="flex flex-col gap-16">
        <h1 class="text-h2 text-center">Les questions les plus fréquentes</h1>
        <div class="flex flex-col gap-8 w-[1000px]">
          @for (item of faqItems; track $index) {
            <app-accordion
              [question]="item.question"
              [answer]="item.answer"></app-accordion>
          }
        </div>
        <div class="flex justify-center">
          <p>
            Besoin de plus d'information ?
            <a routerLink="/contact" class="text-accent-1">Contactez nous !</a>
          </p>
        </div>
      </div>
    </div>
  `,
  styles: ``
})
export class FaqPage {
  faqItems: FaqItem[] = [
    {
      question: "Qu'est ce qui est inclus dans le prix de la location ?",
      answer:
        "Le prix de la location inclut l'hébergement, l'accès aux commodités de la propriété, et les charges courantes (eau, électricité, chauffage). Il peut également inclure certains services supplémentaires comme le nettoyage régulier ou l'entretien du jardin, selon les termes du contrat."
    },
    {
      question: 'À quelle heure puis-je arriver et partir ?',
      answer: "L'heure d'arrivée est à 16h00 et l'heure de départ est à 11h00."
    },
    {
      question: 'Y a-t-il un minimum de nuits pour la réservation ?',
      answer: 'Oui, le minimum de nuits pour la réservation est de 2 nuits.'
    },
    {
      question: "Puis-je prolonger mon séjour après l'avoir réservé ?",
      answer:
        "Oui, vous pouvez prolonger votre séjour après l'avoir réservé, sous réserve de disponibilité."
    },
    {
      question: 'Qui puis-je contacter en cas de problème pendant mon séjour ?',
      answer:
        'Vous pouvez contacter le propriétaire ou le gestionnaire de la propriété en cas de problème pendant votre séjour.'
    },
    {
      question: 'Y a-t-il un parking disponible sur place ?',
      answer: 'Oui, un parking est disponible sur place.'
    },
    {
      question: 'Y a-t-il un accès Wi-Fi ?',
      answer: 'Oui, un accès Wi-Fi est disponible.'
    },
    {
      question:
        'La propriété est-elle accessible aux personnes à mobilité réduite ?',
      answer: 'La propriété est accessible aux personnes à mobilité réduite.'
    }
  ];
}
