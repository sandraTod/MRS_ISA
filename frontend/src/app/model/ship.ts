import { ShipOwner } from './ship-owner';
import { AvailabilityPeriod } from "./availability-period";
import { Reservation } from "./reservation";

export interface Ship {
    
    id?: number;
    name: string;
    address: string;
    city: string;
    description: string;
    pricePerDay: any;
    avgGrade: any;
    reservations?: Reservation[];
    availablePeriods?: AvailabilityPeriod[];
    rules?: string[];
    additionalServices: string;
    cancellationCondition: string
    shipType: string;
    shipLength: string;
    engineNum: string;
    enginePower: string;
    maxSpeed: string;
    capacity: number;
    navigation_equipment?: string[];
    fishing_equipment?: string[];
    owner: ShipOwner; 
    imageUrls: String[];

}