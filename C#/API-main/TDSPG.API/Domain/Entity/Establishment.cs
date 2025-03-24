using System.ComponentModel.DataAnnotations;
using System.Globalization;
using TDSPG.API.Domain.Enums;

namespace TDSPG.API.Domain.Entity
{
    public class Establishment : Audit
    {
        public Guid EstablishmentId { get; private set; }        

        public string Name { get; private set; }

        public string Document { get; private set; }
        
        public EstablishmentType Type { get; private set; }

        public Establishment(string name, string document, EstablishmentType type)
        {
            Name = name;
            Type = type;
            Document = VerifyDocument(document);
            UserCreated = "Thiago";
        }

        private string VerifyDocument(string document)
        {
            if (document.Length < 10)
            {
                throw new Exception("Documento deverá ter mais do que 10 caracteres");
            }

            return document;
        }
    }
}
