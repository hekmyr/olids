import { Component } from '@angular/core';

@Component({
  selector: 'app-three-d-button',
  standalone: true,
  template: `
    <button class="three-d-button">
      <ng-content></ng-content>
    </button>
  `,
  styles: [
    `
      .three-d-button {
        background-color: var(--accent-2-color);
        color: white;
        font-size: 20px;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        box-shadow: 0 8px 0 var(--accent-1-color);
        transition:
          box-shadow 0.1s,
          transform 0.1s;
        cursor: pointer;
      }
      .three-d-button:hover {
        box-shadow: 0 12px 0 var(--accent-1-color);
        transform: translateY(-4px);
      }
      .three-d-button:active {
        box-shadow: 0 4px 0 var(--accent-1-color);
        transform: translateY(4px);
      }
    `
  ]
})
export class ThreeDButtonComponent {}
