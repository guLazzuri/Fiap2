using System.ComponentModel.DataAnnotations;
using TDSPG.API.Domain.Enums;

namespace TDSPG.API.Domain.Entity
{
    public class Establishment
    {
        
        public  Guid EstablishmentId { get; set; }

        public string Name { get; set; }

        public string Document { get; private set; }

        public EstablishmentType Type { get; set; }

        

    }
}
