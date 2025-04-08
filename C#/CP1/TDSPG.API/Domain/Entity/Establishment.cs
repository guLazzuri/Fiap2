using TDSPG.API.Domain.Enums;

namespace TDSPG.API.Domain.Entity
{
    public class Establishment : Audit, IEntity
    {
        public Guid EstablishmentId { get; private set; }

        public string Name { get; private set; }

        public string Document { get; private set; }

        public EstablishmentType Type { get; private set; } = EstablishmentType.Restaurant;

        public Establishment(string name, string document, EstablishmentType type)
        {
            Name = name;
            Type = type;
            Document = VerifyDocument(document);
            UserCreated = "Thiago";
        }

        public Establishment(string name, string document)
        {
            Name = name;
            Document = VerifyDocument(document);
        }

        private string VerifyDocument(string document)
        {
            if (document.Length < 10)
            {
                throw new Exception("Documento deverá ter mais do que 10 caracteres");
            }

            return document;
        }

        public override string GetInfo()
        {
            return $"Estabelecimento criado por {UserCreated} em {CreatedAt}";
        }

        public string GetInfo2()
        {
            return $"Estabelecimento 2 criado por {UserCreated} em {CreatedAt}";
        }
    }
}