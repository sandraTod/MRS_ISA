import { CottageOwner } from './cottage-owner';
import { AvailabilityPeriod } from './availability-period';
import { Reservation } from "./reservation";

export interface Cottage{

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
    numOfRooms: number;
    numOfBeds: number;
    owner: CottageOwner;
    imageUrls?: string[];
    cancellationCondition: string
    
}